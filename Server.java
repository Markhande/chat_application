
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    public static void main(String[] args) {
        System.out.println("Hello i'm server");
        try{
            int port = Integer.parseInt(args[0]);
            ServerSocket ss = new ServerSocket(port);
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            byte[] b1 = new byte[100];
            while (true){
                is.read(b1);
                String s1 = new String(b1).trim();
                System.out.println("From Client: " + s1);
                System.out.print("To Client: ");
                System.in.read(b1);
                os.write(b1);
            }
        } catch(Exception e){
            System.err.println(e);
        }
    }
}
