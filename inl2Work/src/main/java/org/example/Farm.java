package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Farm {
    public void MainMenu() throws IOException {
        File cropsCsv = new File("crops.csv");
        File animalsCsv = new File("animals.csv");
        if(cropsCsv.exists() && animalsCsv.exists()) { }
        else {
            FileWriter writer = new FileWriter(cropsCsv);
            FileWriter writer2 = new FileWriter(animalsCsv);

        }
        boolean menu = true;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Crop> crops = new ArrayList<>();
        ArrayList<Animal> animals = new ArrayList<>();






        //cropsReader
        BufferedReader cropsReader = new BufferedReader(new FileReader("crops.csv"));
        String cropsContent;
        while((cropsContent = cropsReader.readLine()) != null ) {

            String[] cropsAttributes = cropsContent.split(",");
            Crop crop = new Crop(Integer.parseInt(cropsAttributes[0]), cropsAttributes[1], cropsAttributes[2], Integer.parseInt(cropsAttributes[3]));
            crops.add(crop);
        }
        cropsReader.close();

        //animalReader
        BufferedReader animalsReader = new BufferedReader(new FileReader("animals.csv"));
        String animalsContent;
        while((animalsContent = animalsReader.readLine()) != null ) {

            String[] animalsAttributes = animalsContent.split(",");
            Animal animal = new Animal(Integer.parseInt(animalsAttributes[0]), animalsAttributes[1], animalsAttributes[2]);
            animals.add(animal);
        }
        animalsReader.close();

        while (menu == true) {
            System.out.println();
            System.out.println("Welcome to the main menu please choose one of the options below by typing said number.");
            System.out.println();
            System.out.println("1: View crops, 2: Remove crops, 3: Add crops, 4: View animals, 5: Add animal, 6: Feed animal, 7: Remove animal, 8: Save, 9: Exit");
            try {
                String userNumber = scanner.nextLine();

                if (Integer.parseInt(userNumber) == 1) {

                    if(crops.isEmpty()) {

                        System.out.println("You don't have any crops yet!");
                    }
                    else {
                        System.out.println("1: View crops");
                        for (Crop c : crops) {
                            System.out.println();
                            System.out.println(c.GetDescription());
                        }
                    }
                } else if (Integer.parseInt(userNumber) == 2) {

                    if(crops.isEmpty()) {
                        System.out.println();
                        System.out.println("You don't have any crops to remove!");
                    } else {
                        System.out.println("2: Remove crops");
                        System.out.println();
                        System.out.println("Crops: ");
                        System.out.println();
                        for (Crop c : crops) {

                            System.out.println(c.GetDescription());
                        }
                        System.out.println();
                        System.out.println("Enter name of crop to remove: ");
                        String input = scanner.nextLine();
                        boolean foundCrop = false;

                        for (int i = 0; i < crops.size(); i++) {

                            if (crops.get(i).getName().equals(input)) {

                                System.out.println(crops.get(i).getName()+" removed");
                                crops.remove(i);
                                foundCrop = true;

                            }

                        } if(foundCrop == false) {

                            System.out.println("You do not have a crop with the entered name!");

                        }
                    }

                } else if (Integer.parseInt(userNumber) == 3) {
                    System.out.println("3: Add crops");
                    System.out.println();
                    System.out.println("Please enter an id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please enter a crop type: ");
                    String cropType = scanner.nextLine();
                    System.out.println("Please enter a name: ");
                    String cropName = scanner.nextLine();
                    System.out.println("Please enter a quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    Crop crop1 = new Crop(id, cropName, cropType, quantity);
                    crops.add(crop1);
                    System.out.println("Added "+ crop1.GetDescription());


                } else if (Integer.parseInt(userNumber) == 4) {

                    if(animals.isEmpty()) {

                        System.out.println("You do not have any animals to view!");
                    } else {
                        System.out.println("4: View animals");
                        for (Animal a : animals) {
                            System.out.println();
                            System.out.println(a.GetDescription());
                        }
                    }
                } else if (Integer.parseInt(userNumber) == 5) {

                    System.out.println("5: Add animal");
                    System.out.println();
                    System.out.println("Please enter an id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please enter a name: ");
                    String name = scanner.nextLine();
                    System.out.println("Please enter a species: ");
                    String species = (scanner.nextLine());
                    Animal animal1 = new Animal(id, name, species);
                    animals.add(animal1);
                    System.out.println();
                    System.out.println("Added "+animal1.GetDescription());

                } else if (Integer.parseInt(userNumber) == 6) {

                    if(crops.isEmpty() || animals.isEmpty()) {

                        System.out.println("You do not have enough crops and/or any animals to feed!");
                    } else {
                        System.out.println("6: Feed animal");
                        System.out.println();


                        System.out.println("Enter name of crop you want to use: ");
                        String cropsInput = scanner.nextLine();

                        for(int i = 0; i<crops.size(); i++) {

                            boolean foundCrop = false;
                            if (crops.get(i).getName().equals(cropsInput)) {
                                foundCrop = true;
                                int cropQuantity = crops.get(i).getQuantity();
                                if (cropQuantity < 1) {

                                    System.out.println("You do not have enough to feed the animal");
                                    break;


                                }

                                if(foundCrop == true) {

                                    System.out.println("Your crop has the quantity of: " + crops.get(i).getQuantity());
                                    System.out.println();
                                    System.out.println("Enter name of animal you want to feed: ");
                                    String animalsInput = scanner.nextLine();
                                    boolean foundAnimal = false;

                                    for (int d = 0; d < animals.size(); d++) {
                                        if (animals.get(d).getName().equals(animalsInput)) {
                                            foundAnimal = true;
                                            String chosenAnimal = animals.get(d).getName();
                                            System.out.println("You have chosen to feed " + chosenAnimal);
                                            System.out.println();
                                            System.out.println("You have " + cropQuantity + " to feed " + chosenAnimal);
                                            System.out.println();
                                            System.out.println("How much do you want to feed " + chosenAnimal + "?");
                                            System.out.println();
                                            int userAmount = Integer.parseInt(scanner.nextLine());

                                            if(userAmount > cropQuantity) {

                                                System.out.println("You can not feed that much!");



                                            } else {

                                                System.out.println("You fed "+chosenAnimal+" "+(userAmount));
                                                cropQuantity = cropQuantity - userAmount;
                                                crops.get(i).setQuantity(cropQuantity);

                                            } }



                                        } if(foundAnimal == false) {

                                            System.out.println("You do not have an animal with the entered name!");

                                        }

                                    }
                                }




                            }



                        }




                } else if (Integer.parseInt(userNumber) == 7) {

                    System.out.println("Current animals: ");

                    for (Animal a : animals) {
                        System.out.println(a.GetDescription());
                    }
                    System.out.println();

                    System.out.println("7: Remove animal");
                    if(animals.isEmpty()) {

                        System.out.println("You do not have any animals to remove!");
                    } else {
                        System.out.println("Enter name of animal to remove: ");
                        String input = scanner.nextLine();

                            boolean foundAnimal = false;
                        for(int i = 0; i<animals.size(); i++) {

                            if(animals.get(i).getName().equals(input)) {

                                System.out.println(animals.get(i).getName()+" removed");
                                animals.remove(i);
                                System.out.println();
                                foundAnimal = true;

                            }

                        } if(foundAnimal == false) {

                            System.out.println("You do not have an animal with the entered name");


                        }
                    }

                    }


                else if (Integer.parseInt(userNumber) == 8) {

                    System.out.println("8: Save");

                    FileWriter writer = new FileWriter(cropsCsv);
                    FileWriter writer2 = new FileWriter(animalsCsv);


                    for(Crop c : crops) {
                        writer.write(c.GetDescription()+"\n");
                    }

                    writer.close();



                    for(Animal a : animals) {
                        writer2.write(a.GetDescription()+"\n");
                    }

                    writer2.close();

                    System.out.println();
                    System.out.println("Files saved");

                } else if (Integer.parseInt(userNumber) == 9) {

                    System.out.println("9: Exit");
                    System.out.println("Exiting, have a great day!");
                    menu = false;
                } else {
                    System.out.println("Please type a number from 1-9");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number from 1-9");
            }
        }
    }
}
