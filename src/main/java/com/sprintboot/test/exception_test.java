//package com.sprintboot.test;
//
//public class exception_test {
//
//    public static void main(String[] args) {
//        User u = new User();
//        class Set_Thread extends Thread {
//            @Override
//            public void run() {
//                u.setName(Thread.currentThread().getName());
//                System.out.println(u.getName());
//            }
//        }
//        while (true) {
//            Thread t1 = new Set_Thread();
//            Thread t2 = new Set_Thread();
//            Thread t3 = new Set_Thread();
//            Thread t4 = new Set_Thread();
//            t1.start();
//            t2.start();
//            t3.start();
//            t4.start();
//        }
//    }
//}
