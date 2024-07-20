package desafio.poo.dio;

import java.util.Scanner;



abstract class Cofre {

    protected String tipo;

    protected String metodoAbertura;



    public Cofre(String tipo, String metodoAbertura) {

        this.tipo = tipo;

        this.metodoAbertura = metodoAbertura;

    }



    public void imprimirInformacoes() {

        System.out.println("Tipo: " + this.tipo);

        System.out.println("Metodo de abertura: " + this.metodoAbertura);

    }





    public abstract void abrir(int senha);

}



class CofreDigital extends Cofre {

    private int senha;



    public CofreDigital(int senha) {

        super("Cofre Digital", "Senha");

        this.senha = senha;

    }



    @Override

    public void abrir(int senha) {

        if (senha == this.senha) {

            System.out.println("Cofre aberto!");

        } else {

            System.out.println("Senha incorreta!");

        }

    }

}



class CofreFisico extends Cofre {

    public CofreFisico() {

        super("Cofre Fisico", "Chave");

    }



    @Override

    public void abrir(int senha) {

    }

}



public class DesafioCofre {

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        String tipoCofre = scanner.nextLine();





        if (tipoCofre.equalsIgnoreCase("digital")) {

            int senha = scanner.nextInt();
            int senhaConfimacao = scanner.nextInt();

            CofreDigital cofreDigital = new CofreDigital(senhaConfimacao);

            cofreDigital.imprimirInformacoes();

            cofreDigital.abrir(senha);

        } else if (tipoCofre.equalsIgnoreCase("fisico")) {



            CofreFisico cofreFisico = new CofreFisico();

            cofreFisico.imprimirInformacoes();

        }



        scanner.close();

    }

}