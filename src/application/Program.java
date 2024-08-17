package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int quartoNum = sc.nextInt();
        System.out.print("Data do check-in (DD/MM/AAAA): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data do check-out (DD/MM/AAAA): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)){
            System.out.println("Erro na reserva: Check-out deve ser uma data após o check-in");
            System.out.println();
        }
        else {
            Reservation reservation = new Reservation(quartoNum, checkIn, checkOut);
            System.out.println("Reserva: "+ reservation);

            System.out.println();
            System.out.println("Digite os dados para atualizar a reserva: ");
            System.out.print("Data do check-in (DD/MM/AAAA): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data do check-out (DD/MM/AAAA): ");
            checkOut = sdf.parse(sc.next());

            String error = reservation.updateDates(checkIn, checkOut);
            if(error != null){
                System.out.println("Erro: na reserva: "+ error);
            } else {
                System.out.println("Reserva: "+ reservation);
            }

        }
        sc.close();
    }
}
