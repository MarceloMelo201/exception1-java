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

            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("Erro nas reservas: Datas de reservação devem ser futuras");
            }
            else if (!checkOut.after(checkIn)) {
                System.out.println("Erro na reserva: Check-out deve ser uma data após o check-in");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reserva: "+ reservation);
            }

        }

        sc.close();
    }
}
