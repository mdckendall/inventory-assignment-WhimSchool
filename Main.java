import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
  public String name;
  public String serial;
  public int value;

  public Inventory(String name, String serial, int value){
    this.name = name;
    this.serial = serial;
    this.value = value;
  }
}

class Main {
	public static void main(String[] args) {
    ArrayList<Inventory> inventories = new ArrayList<Inventory>();
    Scanner input = new Scanner(System.in);
    Boolean quit = false;

    while(quit == false){
      Menu();
      int choice = input.nextInt();
      input.nextLine();
      
      switch (choice){
        case 1:
          inventories.add(Add(input));
          break;

        case 2:
          Delete();
          String tempString = input.nextLine();
          for (Inventory i : inventories){
            if(i.serial.equals(tempString)){
              inventories.remove(i);
            }
          }
          break;

        case 3:
          Inventory tempInv = Update(input);
          for (Inventory i : inventories){
            if(i.serial.equals(tempInv.serial)){
              i.name = tempInv.name;
              i.value = tempInv.value;
            }
          }
          break;
    
        case 4:
          for (Inventory i : inventories){
            System.out.println(i.name + "," + i.serial + "," + i.value);
          }
          break;

        case 5:
          quit = true;
      }
    }
  }
          
  static void Menu(){
    System.out.println("Press 1 to add an item.");
    System.out.println("Press 2 to delete an item.");
    System.out.println("Press 3 to update an item.");
    System.out.println("Press 4 to show all the items.");
    System.out.println("Press 5 to quit the program.");
  }

  static Inventory Add(Scanner input){
    System.out.println("Enter the name:");
    String tempName = input.nextLine();
    System.out.println("Enter the serial number:");
    String tempSerial = input.nextLine();
    System.out.println("Enter the value in dollars (whole number):");
    int tempInt = input.nextInt();
    input.nextLine();

    Inventory returnObj = new Inventory(tempName, tempSerial, tempInt); 
    return returnObj;
  }
  
  static void Delete(){
    System.out.println("Enter the serial number of the item to delete:");
  }
  
  static Inventory Update(Scanner input){
    System.out.println("Enter the serial number of the item to change:");
    String tempSerial = input.nextLine();
    System.out.println("Enter the new name:");
    String tempName = input.nextLine();
    System.out.println("Enter the new value in dollars (whole number):");
    int tempInt = input.nextInt();
    input.nextLine();

    Inventory returnObj = new Inventory(tempName, tempSerial, tempInt); 
    return returnObj;
  }
}



