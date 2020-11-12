package netty.handlers;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class OutPutHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg,
                      ChannelPromise promise) throws Exception {
        String message = (String) msg;
        ByteBuf buf = ctx.alloc().directBuffer();
        System.out.println("out: " + message);
        buf.writeBytes(message.getBytes());
        System.out.println(ctx.channel());
        ByteBufInputHandler.broadCastMessage(buf);
    }
}
