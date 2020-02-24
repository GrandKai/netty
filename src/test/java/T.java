import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Random;

/**
 * @Author: Administrator
 * @Description:
 * @Date: Created in 2020-01-03 10:10
 * @Modified By:
 */
public class T {

    public static void main(String[] args) throws InterruptedException {
        ByteBuf byteBuf = Unpooled.buffer(5, 100);

        System.out.println("capacity: " + byteBuf.capacity());
        System.out.println("maxCapacity: " + byteBuf.maxCapacity());
        System.out.println("可写字节：writableBytes: " + byteBuf.writableBytes());
        System.out.println("readerIndex: " + byteBuf.readerIndex());
        System.out.println("writerIndex: " + byteBuf.writerIndex());

        System.out.println("可写字节：" + byteBuf.writableBytes());
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            int i1 = random.nextInt();
            System.out.println("writerIndex: " + byteBuf.writerIndex() + " = " + i1);

            byteBuf.writeInt(i1);
        }

        System.out.println("=======================================================");

        System.out.println("byteBuf readerIndex: " + byteBuf.readerIndex());
        System.out.println("byteBuf writerIndex: " + byteBuf.writerIndex());
        System.out.println("byteBuf writableBytes: " + byteBuf.writableBytes());

        System.out.println("=======================================================");

        ByteBuf byteBuf1 = Unpooled.buffer(100);
        System.out.println("可读取的字节：" + byteBuf.readBytes(byteBuf1));

        System.out.println("byteBuf readerIndex: " + byteBuf.readerIndex());
        System.out.println("byteBuf writerIndex: " + byteBuf.writerIndex());
        System.out.println("byteBuf writableBytes: " + byteBuf.writableBytes());

        System.out.println("=======================================================");

        System.out.println("byteBuf1 readerIndex: " + byteBuf1.readerIndex());
        System.out.println("byteBuf1 writerIndex: " + byteBuf1.writerIndex());
        System.out.println("byteBuf1 writableBytes: " + byteBuf1.writableBytes());


        System.out.println("=======================================================");

        byteBuf.resetReaderIndex();
        System.out.println("byteBuf readerIndex: " + byteBuf.readerIndex());
        System.out.println("byteBuf writerIndex: " + byteBuf.writerIndex());
        System.out.println("byteBuf writableBytes: " + byteBuf.writableBytes());
        System.out.println("=======================================================");

        ByteBuf writeable = Unpooled.buffer();
        writeable.writeBytes(byteBuf);

        writeable.readByte();

        System.out.println("writeable readerIndex: " + writeable.readerIndex());
        System.out.println("writeable readableBytes: " + writeable.readableBytes());
        System.out.println("writeable writerIndex: " + writeable.writerIndex());
        System.out.println("writeable writableBytes: " + writeable.writableBytes());


        System.out.println("=======================================================");

        System.out.println("byteBuf readerIndex: " + byteBuf.readerIndex());
        System.out.println("byteBuf writerIndex: " + byteBuf.writerIndex());
        System.out.println("byteBuf writableBytes: " + byteBuf.writableBytes());
        System.out.println("=======================================================");


    }
}
