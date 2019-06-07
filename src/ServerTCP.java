import java.io.*;
import java.net.*;
import java.util.*;


public class ServerTCP {

    public static void main(String[] args) {


        try{
            ServerSocket servidor = new ServerSocket(33366);
            System.out.println("Servidor escutando port : 33366");


            while (true){
                Socket cliente = servidor.accept(); // accept() -> bloqueia exec até servidor receber conexão
                System.out.println("Cliente conectado : " + cliente.getInetAddress().getHostAddress());
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());

                saida.flush();
                saida.writeObject(new Date());
                saida.close();
                cliente.close();

            }
        }

        catch (Exception e){
            System.out.println(" Error: " + e.getMessage());
        }

        finally {
            System.out.println("Sistema Funcionando.");
        }

    }
}
