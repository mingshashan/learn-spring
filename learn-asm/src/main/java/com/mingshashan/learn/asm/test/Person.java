package com.mingshashan.learn.asm.test;

public class Person {
    private String name = "Person";
    int age = 0;
}

public class Child extends Person {
    public String grade;

    public static void main(String[] args) {
        Person p = new Child();
        System.out.println(p.name);
    }

    public static CoreElement ajc$interMethod$org_apache_axiom_core_CoreDocumentSupport$org_apache_axiom_core_CoreDocument$coreGetDocumentElement(CoreDocument ajc$this_) {
        for(CoreChildNode child = CoreParentNodeSupport.ajc$interMethodDispatch1$org_apache_axiom_core_CoreParentNodeSupport$org_apache_axiom_core_CoreParentNode$coreGetFirstChild(ajc$this_); child != null; child = CoreChildNodeSupport.ajc$interMethodDispatch1$org_apache_axiom_core_CoreChildNodeSupport$org_apache_axiom_core_CoreChildNode$coreGetNextSibling(child)) {
            if (child instanceof CoreElement) {
                return (CoreElement)child;
            }
        }

        return null;
    }
}