public class BuilderTest {

    public static void main(String[] args) {

        ComputerBuilder desktopBuilder = new DesktopBuilder();
        Director director1 = new Director(desktopBuilder);

        director1.constructComputer();
        Computer desktop = desktopBuilder.getComputer();

        System.out.println("Desktop Configuration:");
        desktop.showComputer();

        ComputerBuilder laptopBuilder = new LaptopBuilder();
        Director director2 = new Director(laptopBuilder);

        director2.constructComputer();
        Computer laptop = laptopBuilder.getComputer();

        System.out.println("Laptop Configuration:");
        laptop.showComputer();
    }
}