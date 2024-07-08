package Temperature;

import Temperature.observer.Publisher;

public class TemperatureModel extends Publisher {
    private double celsius;
    private double fahrenheit;

    public void c2f(double celsius) {
        this.fahrenheit = (celsius * 9 / 5) + 32;
        changeFahrenheit();
    }

    public void f2c(double fahrenheit) {
        this.celsius = (fahrenheit - 32) * 5 / 9;
        changeCelsius();
    }

    private void changeCelsius() {
        notifyChangeCelsius();
    }

    private void changeFahrenheit() {
        notifyChangeFahrenheit();
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }
}
