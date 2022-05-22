package my.utils;

import my.model.HBGGZPW;
import my.model.QCWY;
import my.threads.TaskHBGGZPW;
import my.threads.Task_QCWY;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Util_HBGGZPW {
  public static List<HBGGZPW> getData(int page)  {
    List<TaskHBGGZPW> taskList=new ArrayList<>();
    CountDownLatch downLatch = new CountDownLatch(page);
    for (int i = 1; i <page+1 ; i++) {
      TaskHBGGZPW taskHBGGZPW = new TaskHBGGZPW(i + "");
      taskHBGGZPW.setCountDownLatch(downLatch);
      taskList.add(taskHBGGZPW);
    }
    ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    for (TaskHBGGZPW taskHBGGZPW : taskList) {
      if (!taskHBGGZPW.ok){
        threadPool.execute(taskHBGGZPW);
      }
    }
    try {
      downLatch.await();
      threadPool.shutdown();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ArrayList<HBGGZPW> lists = new ArrayList<>();
    for (TaskHBGGZPW taskHBGGZPW : taskList) {
      if (taskHBGGZPW.ok){
        lists.addAll(taskHBGGZPW.getList());
      }
    }

  return  lists;
  }

  public static List<QCWY.EngineJdsDTO> getData(String keyword,int page){
    CountDownLatch latch = new CountDownLatch(page);
    ArrayList<Task_QCWY> list = new ArrayList<>();
    for (int i = 1; i <page+1 ; i++) {
      Task_QCWY qcwy = new Task_QCWY(keyword, i + "");
      qcwy.setLatch(latch);
      list.add(qcwy);
    }
    ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    for (Task_QCWY taskQcwy : list) {
      threadPool.execute(taskQcwy);
    }
    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    ArrayList<QCWY.EngineJdsDTO> data = new ArrayList<>();
    for (Task_QCWY qcwy : list) {
      data.addAll(qcwy.getData());
    }
    threadPool.shutdown();
    return data;
  }

}
