import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class ClientTCP {
    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("Kaline", 33366);
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            Date data_atual = (Date)entrada.readObject();
            JOptionPane.showMessageDialog(null,"Data recebida do servidor:" + data_atual.toString());
            entrada.wait(400);
            entrada.close();
            System.out.println("Conexão encerrada");
        }
        catch(Exception e) {
            System.out.println("Erro na conexão do host -> " + e.getMessage());
        }
    }
}
