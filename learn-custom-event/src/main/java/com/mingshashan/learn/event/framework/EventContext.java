
package com.mingshashan.learn.event.framework;

import java.util.ArrayList;
import java.util.List;

public class EventContext {
    private Event parent= null;
    private List<Event> eventList= new ArrayList<Event>();
    private int currentPos=0;
    private List<Throwable> exceptionList=null;
    boolean isUseTxSegment = false;

    public EventContext getRootContext(){
        EventContext eventContext = this;
        while(eventContext.parent!=null){
            eventContext = eventContext.parent.getOwnerEventCtx();
        }
        return eventContext;
    }
    
    public List getExceptionList(){
        return this.exceptionList;
    }
    public void addExceptionToRootContext(Throwable th){
        getRootContext().addExceptionToContext(th);
    }
    
    public void addExceptionToContext(Throwable th){
        if (exceptionList==null){
            exceptionList = new ArrayList<Throwable>();
        }
        exceptionList.add(th);
    }
    
    /**
     * clear up all the data
     *
     */
    public void clear(){
        parent = null;
        eventList.clear();
        currentPos=0;
        if (exceptionList!=null) exceptionList.clear();
    }
    
    public void setParent(Event aParent){
        this.parent = aParent;
    }
    public Event getParent(){
        return parent;
    }
    
    /**
     * 追加事件到队列末尾
     * @param event
     */
    public void addEvent(Event event){
        event.setOwnerEventCtx(this);
        this.eventList.add(event);
        event.setUseTxSegment(this.isUseTxSegment);
    }
    
    /**
     * 插入事件到队列中当前事件之后
     * @param event
     */
    public void insertEvent(Event event){
    	event.setOwnerEventCtx(this);
    	this.eventList.add(this.currentPos+1,event);
    	event.setUseTxSegment(this.isUseTxSegment);
    }
    
    /**
     * 如果存在父队列则追加到父队列末尾，否则追加到当前对列末尾
     * @param event
     */
    public void addEventToPanrent(Event event){
    	if(this.parent!=null){
    		this.parent.getOwnerEventCtx().addEvent(event);
    	}else{
    		this.addEvent(event);
    	}
    }
    
    /**
     * if has next event, return true
     * else return false.
     * if call it when already has no next event, still return false
     * @return
     */
    public boolean moveToNextEvent(){
        int eventSize=eventList.size();
        if (currentPos < eventSize) currentPos++;
        
        if (currentPos == eventSize)
            return false;
        else if (currentPos < eventSize)
            return true;
        else
            throw new RuntimeException("imporsable"); 
    }
    
    /**
     * check is stopped. if the event has move after the last ,return true, else false
     * @return
     */
    public boolean isStopped() {
        int eventSize = eventList.size();
        if (currentPos == eventSize)
            return true;
        else if (currentPos < eventSize)
            return false;
        else
            throw new RuntimeException("impossible to come here");
    }
    
    /**
     * get current Event
     * if has move to tail, Exception will be throwed.
     * @return
     */
    public Event getCurrentEvent() {
        return (Event) eventList.get(currentPos);
    }
    
    public int size(){
        return this.eventList.size();
    }
    
    public Event getAtPos(int i){
        return (Event) this.eventList.get(i);
    }
    
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("\nEventContext{ parent="+ ((parent==null)?"null":String.valueOf(parent.hashCode())));
        for (int i=0;i<eventList.size();i++){
            sb.append("\n event"+i+":"+eventList.get(i));
        }
        
        sb.append("\n currentPos="+currentPos);
        sb.append("\n isStopped="+isStopped());
        sb.append("\n}");
        
        return sb.toString();
    }

	/**
	 * @return Returns the isUseTxSegment.
	 */
	public boolean isUseTxSegment() {
		return isUseTxSegment;
	}

	/**
	 * @param isUseTxSegment The isUseTxSegment to set.
	 */
	public void setUseTxSegment(boolean isUseTxSegment) {
		this.isUseTxSegment = isUseTxSegment;
	}
}



