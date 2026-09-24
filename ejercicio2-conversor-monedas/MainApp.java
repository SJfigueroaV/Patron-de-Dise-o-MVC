public class MainApp {

    public static void main(String[] args) {
        
        DivisaView view = new DivisaView();
        DivisaModel model = new DivisaModel(0);

        new DivisaControler(view, model);

        view.setVisible(true);

    }
}