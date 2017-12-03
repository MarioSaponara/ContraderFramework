package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Gomma;
import main.service.GommaService;

import java.util.List;
import java.util.Scanner;

public class GommaView implements View {

    private GommaService gommaService;
    private String mode;
    private String role;
    private String nome;

    public GommaView () {
      this.gommaService = new GommaService();
      this.mode = "all";
    }

    @Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
            role = (String) request.get("role");
            nome = (String) request.get("nome");
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "all":
                List<Gomma> gomme = gommaService.getAllGomme();
                System.out.println("----- Gomme disponibili -----");
                System.out.println();
                gomme.forEach(gomma -> System.out.println(gomma));
                break;
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci i dati della nuova gomma:");
                System.out.println("Modello:");
                String model = getInput();
                System.out.println("Produttore:");
                String manufacturer = getInput();
                System.out.println("Prezzo:");
                double price = Double.parseDouble(getInput());
                System.out.println("Larghezza:");
                double width = Double.parseDouble(getInput());
                System.out.println("Altezza:");
                double height = Double.parseDouble(getInput());
                System.out.println("Diametro:");
                double diameter = Double.parseDouble(getInput());
                System.out.println("Carico:");
                double weight = Double.parseDouble(getInput());
                System.out.println("Velocità:");
                String speed = getInput();
                System.out.println("Stagione:");
                String season = getInput();
                System.out.println("Tipo veicolo:");
                String typevehicle = getInput();
                System.out.println("Numeri pezzi:");
                Integer quantity = Integer.parseInt(getInput());
                gommaService.insertGomma(new Gomma (null, model, manufacturer, price, width, height, diameter, weight, speed, season, typevehicle, quantity));
                break;
            case "allGommeForBrandAndTypeVehicle":
                System.out.println("Inserisci il tuo tipo di veicolo(auto-commerciale-moto):");
                String type = getInput();
                List<String> brands = gommaService.getAllManufacturerForType(type);
                System.out.println("-----Brand disponibili--------");
                brands.forEach(String -> System.out.println(String));
                System.out.println("-----Scegli il brand--------");
                String brand = getInput();
                List<Gomma> gommeBrand = gommaService.getAllGommeForManufacturer(brand, type);
                gommeBrand.forEach(gomma -> System.out.println(gomma));
                break;
            case "allGommeForDimension":
                System.out.println("Inserisci il tuo tipo di veicolo(auto-commerciale-moto):");
                String type2 = getInput();
                System.out.println("Inserisci le caratteristiche del tuo veicolo");
                System.out.println("Larghezza:");
                double width2 = Double.parseDouble(getInput());
                System.out.println("Altezza:");
                double height2 = Double.parseDouble(getInput());
                System.out.println("Diametro:");
                double diameter2 = Double.parseDouble(getInput());
                System.out.println("Stagione:");
                String season2 = getInput();
                String speed2="";
                double weight2=0;
                if(!type2.equals("auto")) {
                    System.out.println("Velocità:");
                    speed2 = getInput();
                    System.out.println("Carico:");
                    weight2 = Double.parseDouble(getInput());
                }
                List<Gomma> gommeForDimension=gommaService.allGommaForDimension(type2, width2, height2, diameter2, season2, weight2, speed2);
                gommeForDimension.forEach(gomma -> System.out.println(gomma));
        }
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.put("role", role);
        request.put("nome", nome);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);
    }

}
