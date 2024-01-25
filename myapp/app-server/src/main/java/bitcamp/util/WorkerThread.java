package bitcamp.util;

public class WorkerThread extends Thread {

  Pooling<WorkerThread> pool; // 작업 완료 후 Pool로 돌아가기 때문에 Pool 주소를 저장할 변수
  Worker worker;

  public WorkerThread(Pooling<WorkerThread> pool) {
    this.pool = pool;
  }

  synchronized public void setWorker(Worker worker) {
    this.worker = worker;
    this.notify(); // notify()는 항상 synchronized 블록 안에서 실행되어야 한다!
    // 스레드에 워커를 설정하는 순간 깨우기
  }

  @Override
  public void run() {
    try {
      while (true) {
        synchronized (this) {
          this.wait(); // 바로 not Runnable 상태로 진입한다.(notify()호출 시 run상태로 진입)
        }
        try {
          worker.play();
        } catch (Exception e) {
          System.out.println("클라이언트 요청 처리 중 오류 발생!");
          e.printStackTrace();
        }
        // 작업을 완료했으면 다시 풀로 돌아간다.
        pool.revert(this);
      }
    } catch (Exception e) {
      System.out.println("스레드 예외 발생");
      e.printStackTrace();
    }
  }
}
