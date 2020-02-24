import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Administrator
 * @Description:
 * @Date: Created in 2019-12-19 13:13
 * @Modified By:
 */
public class BIOTest {


    /**
     * 服务器启动后，使用 telnet 连接服务器，查看输出
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("ServerSocket 服务启动：....");

        // 让 ServerSocket 一直阻塞，接收新的连接
        while (true) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            System.out.println("当前线程1：" + Thread.currentThread().getName());
            final Socket socket = serverSocket.accept();

            System.out.println("创建新线程，开始执行 ServerSocket：....");
            executorService.execute(new Runnable() {
                public void run() {
                    hanlder(socket);
                }
            });

        }


    }

    /**
     * 连接处理类
     * @param socket
     */
    private static void hanlder(final Socket socket) {

        InputStream inputStream = null;
        byte[] bytes = new byte[1024];

        try {
            inputStream = socket.getInputStream();

            int length = 0;

            while ((length = inputStream.read(bytes)) != -1) {
                System.out.println("当前线程2：" + Thread.currentThread().getName() + " 循环读取 inputstream :" + length);
                System.out.println(new String(bytes, 0, length));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("客户端socket关闭连接" + Thread.currentThread().getName());
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
