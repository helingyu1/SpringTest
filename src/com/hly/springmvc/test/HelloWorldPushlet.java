package com.hly.springmvc.test;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventPullSource;

public class HelloWorldPushlet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(HelloWorldPushlet.class);
	public static class HWPushlet extends EventPullSource {

       
        @Override
        protected long getSleepTime() {
              return 1000;//ÿһ�����Զ�ִ��һ��
        }

       
        @Override
        protected Event pullEvent() {
          //ע�⣬һ�����趨��Ϣ������/guoguo/helloworld���ų������ǿ��Լ̳е�
         //���Ǳ��ߵĲ�����ʧ�ܵģ�Ҳ�������ԣ��Ǻ�
              Event event = Event.createDataEvent("/hly/helloworld");
              String data= "hello,world hly ";
//              try {
//                   data=new String(data.getBytes("UTF-8"),"ISO-8859-1");
//              } catch (UnsupportedEncodingException e) {
//                   e.printStackTrace();
//              }
              event.setField("hw",data);
              return event;
        }

   }
}
