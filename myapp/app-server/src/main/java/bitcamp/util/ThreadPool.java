package bitcamp.util;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool implements Pooling<WorkerThread> { // Pooling 규칙에 따라 WorkerThread를 다룸


  List<WorkerThread> list = new ArrayList<>();

  // 처음에 스레드를 미리 일정 개수 생성해 두기
  public ThreadPool(int initSize) {
    if (initSize <= 0 || initSize > 100) {
      return;
    }
    for (int i = 0; i < initSize; i++) {
      list.add(create());
    }
  }

  @Override
  public WorkerThread get() {
    if (list.size() > 0) {
      return list.remove(0);
    }
    return create();
  }

  @Override
  public void revert(WorkerThread thread) {
    list.add(thread);
  }

  private WorkerThread create() {
    WorkerThread thread = new WorkerThread(this);
    thread.start();
    try {
      Thread.sleep(500); // 스레드가 wait 할 시간을 확보
    } catch (Exception e) {
    }
    return thread;
  }
}
