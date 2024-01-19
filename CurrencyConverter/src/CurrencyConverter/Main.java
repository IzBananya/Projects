package CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;


public class Main
{
    public static void main(String[] args)
    {
        NumberFormat eng = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat jpn = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        NumberFormat uk = NumberFormat.getCurrencyInstance(Locale.UK);
        String[] currencies = {"Australian Dollar (AUD)", "Swiss Franc (CHF)", "Euro (EUR)", "Pound Sterling (GBP)", "Japanese Yen (JPY)"};
        Scanner input = new Scanner(System.in);
        boolean active = true;

        System.out.println("This program converts USD to one of the other 6 major currencies:");
        for (int i = 0; i < currencies.length; i++)
        {
            System.out.println(currencies[i]);
        }
        while(active) {
            System.out.print("Which currency would you like to convert to? (Enter abbreviation): ");
            String choice = input.next();
            if (choice.equals("AUD")) {
                AUD aud = new AUD();
                System.out.print("How much would you like to convert to AUD?: $");
                double amount = input.nextDouble();
                System.out.println(eng.format(amount) + " USD is roughly " + eng.format(AUD.convert(amount)) + " in AUD");
                System.out.print("Would you like to convert another currency?: (Y/N): ");
                String retry = input.next();
                if (retry.equals("Y"))
                {
                    continue;
                }
                if (retry.equals("N"))
                {
                    System.out.println("Thanks for trying the program.");
                    break;
                }
                else
                {
                    System.out.print("Try again: ");
                    String tryagain = input.next();
                    if (tryagain.equals("Y"))
                    {
                        continue;
                    }
                    else
                    {
                        System.out.println("Thanks for trying the program.");
                        break;
                    }
                }

            }

            if (choice.equals("CHF")) {
                CHF chf = new CHF();
                System.out.print("How much would you like to convert to CHF?: $");
                double amount = input.nextDouble();
                System.out.println(eng.format(amount) + " USD is roughly " + eng.format(CHF.convert(amount)) + " in CHF");
                System.out.print("Would you like to convert another currency?: (Y/N): ");
                String retry = input.next();
                if (retry.equals("Y"))
                {
                    continue;
                }
                if (retry.equals("N"))
                {
                    System.out.println("Thanks for trying the program.");
                    break;
                }
                else
                {
                    System.out.print("Try again: ");
                    String tryagain = input.next();
                    if (tryagain.equals("Y"))
                    {
                        continue;
                    }
                    else
                    {
                        System.out.println("Thanks for trying the program.");
                        break;
                    }
                }
            }

            if (choice.equals("EUR")) {
                EUR eur = new EUR();
                System.out.print("How much would you like to convert to EUR?: $");
                double amount = input.nextDouble();
                System.out.println(eng.format(amount) + " USD is roughly " + eng.format(EUR.convert(amount)) + " in EUR");
                System.out.print("Would you like to convert another currency?: (Y/N): ");
                String retry = input.next();

                if (retry.equals("Y"))
                {
                    continue;
                }
                if (retry.equals("N"))
                {
                    System.out.println("Thanks for trying the program.");
                    break;
                }
                else
                {
                    System.out.print("Try again: ");
                    String tryagain = input.next();
                    if (tryagain.equals("Y"))
                    {
                        continue;
                    }
                    else
                    {
                        System.out.println("Thanks for trying the program.");
                        break;
                    }
                }
            }

            if (choice.equals("GBP")) {
                GBP gbp = new GBP();
                System.out.print("How much would you like to convert to GBP?: $");
                double amount = input.nextDouble();
                System.out.println(eng.format(amount) + " USD is roughly " + uk.format(GBP.convert(amount)) + " in GBP");
                System.out.print("Would you like to convert another currency?: (Y/N): ");
                String retry = input.next();
                if (retry.equals("Y"))
                {
                    continue;
                }
                if (retry.equals("N"))
                {
                    System.out.println("Thanks for trying out the program.");
                    break;
                }
                else
                {
                    System.out.print("Try again: ");
                    String tryagain = input.next();
                    if (tryagain.equals("Y"))
                    {
                        continue;
                    }
                    else
                    {
                        System.out.println("Thanks for trying the program.");
                        break;
                    }
                }
            }

            if (choice.equals("JPY")) {
                JPY jpy = new JPY();
                System.out.print("How much would you like to convert to JPY?: $");
                double amount = input.nextDouble();
                System.out.println(eng.format(amount) + " USD is roughly " + jpn.format(JPY.convert(amount)) + " in JPY");
                System.out.print("Would you like to convert another currency?: (Y/N): ");
                String retry = input.next();

                if (retry.equals("Y"))
                {
                    continue;
                }
                if (retry.equals("N"))
                {
                    System.out.println("Thanks for trying the program.");
                    break;
                }
                else
                {
                    System.out.print("Try again: ");
                    String tryagain = input.next();
                    if (tryagain.equals("Y"))
                    {
                        continue;
                    }
                    else
                    {
                        System.out.println("Thanks for trying the program.");
                        break;
                    }
                }
            }
        }
    }
}