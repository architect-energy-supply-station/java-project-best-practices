package com.dmsdbj.team3.javaprojectbestpractices.testcopy;

import java.io.*;

/**
 * @ClassName java-project-best-practices
 * @Author cookr
 * @Date 2019/12/23 7:26 下午
 * @Version 1.0
 * @Description
 **/


public class Email implements Serializable {
    private Attachment attachment;

    public Email(Attachment attachment) {
        this.attachment = attachment;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void display() {
        System.out.println("查看邮件");
    }

    public Object deepCloen() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);


        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (ois.readObject());
    }
}

