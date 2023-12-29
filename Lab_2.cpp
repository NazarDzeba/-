#include <iostream>
#include <vector>
using namespace std;
class Product {
private:
    string name;
public:
    Product(const string& productName) : name(productName) {}
    string getName() const {
        return name;
    }
};
class Workshop {
private:
    string name;
    vector<Product> products;
    static int totalWorkshops; 
public:
    Workshop(const string& workshopName) : name(workshopName) {
        totalWorkshops++;
    }
    void addProduct(const Product& product) {
        products.push_back(product);
    }
    vector<Product> getProducts() const {
        return products;
    }
    static int getTotalWorkshops() {
        return totalWorkshops;
    }
};
int Workshop::totalWorkshops = 0; 
class Enterprise {
private:
    string name;
    vector<Workshop> workshops;
    static int totalEnterprises; 
public:
    Enterprise(const string& enterpriseName) : name(enterpriseName) {
        totalEnterprises++; 
    }
    void addWorkshop(const Workshop& workshop) {
        workshops.push_back(workshop);
    }
    vector<Workshop> getWorkshops() const {
        return workshops;
    }
    static int getTotalEnterprises() {
        return totalEnterprises;
    }
};
int Enterprise::totalEnterprises = 0; 
int main() {
    Product bus("Автобус");
    Product car("Легковий автомобіль");
    Workshop workshop1("Цех 1");
    workshop1.addProduct(bus);
    Workshop workshop2("Цех 2");
    workshop2.addProduct(car);
    Enterprise enterprise("Автомобілебудівне підприємство");
    enterprise.addWorkshop(workshop1);
    enterprise.addWorkshop(workshop2);
    cout << "Загальна кількість цехів: " << Workshop::getTotalWorkshops() << endl;
    cout << "Загальна кількість підприємств: " << Enterprise::getTotalEnterprises() << endl;

    return 0;
}
