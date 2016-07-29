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
              return 1000;//每一秒钟自动执行一次
        }

       
        @Override
        protected Event pullEvent() {
          //注意，一下是设定消息的主题/guoguo/helloworld，号称主题是可以继承的
         //但是笔者的测试是失败的，也许方法不对，呵呵
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
