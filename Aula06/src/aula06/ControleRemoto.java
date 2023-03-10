package aula06;

/**
 *
 * @author Daniel da Silva de Lima
 */
public class ControleRemoto implements Controlador{
    // Atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;
    
    // Construtor
    public ControleRemoto() {
        this.volume = 50;
        this.ligado = true;
        this.tocando = false;
    }
    // Métodos Especiais
    private int getVolume() {
        return this.volume;
    }
    private void setVolume(int v) {
        this.volume = v;
    }
    private boolean getLigado() {
        return this.ligado;
    }
    private void setLigado(boolean l) {
        this.ligado = l;
    }
    private boolean getTocando() {
        return this.tocando;
    }
    private void setTocando(boolean t) {
        this.tocando = t;
    }
    // Métodos Personalizados

    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        if (this.getLigado()) {
        System.out.println("---- MENU ----");
        System.out.println("Está ligado? " + this.getLigado());
        System.out.println("Está tocando? " + this.getTocando());
        System.out.print("Volume: " + this.getVolume());
        for (int i = 0; i < this.getVolume(); i+=10) {
            System.out.print("|");
        }
        } else {
            System.out.println("Impossível abrir o MENU");
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Menu...");
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()) {
            this.setVolume(this.getVolume() + 5);
        } else {
            System.out.println("Impossível aumentar volume");
        }
    }

    @Override
    public void menosVolume() {
        if (this.getLigado()) {
            this.setVolume(this.getVolume() - 5);
        } else {
            System.out.println("Impossível diminuir o volume");
        }
    }

    @Override
    public void ligarMudo() {
        if (this.getLigado() && this.getVolume() > 0) {
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if (this.getLigado() && !(this.getTocando())) {
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if (this.getLigado() && this.getTocando() == false) {
            this.setTocando(true);
        } else {
            System.out.println("Não consegui reproduzir");
        }
    }

    @Override
    public void pause() {
        if (this.getLigado() && this.getTocando()) {
            this.setLigado(false);
        } else {
            System.out.println("Não consigo pausar");
        }
    }
    
}
