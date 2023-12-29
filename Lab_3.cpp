#include <iostream>
#include <string>
#include <vector>
using namespace std;
class Product {
protected:
    string name;
    string category;
public:
    Product(const string& name, const string& category) : name(name), category(category) {}

    virtual void assemble() {
        cout << "Assembling " << category << ": " << name << endl;
    }
};
class Bus : public Product {
private:
    int capacity;
public:
    Bus(const string& name, int capacity) : Product(name, "Bus"), capacity(capacity) {}
    void assemble() override {
        cout << "Assembling Bus: " << name << " (Capacity: " << capacity << " passengers)" << endl;
    }
};
class AgriculturalMachine : public Product {
private:
    int productivity;
public:
    AgriculturalMachine(const string& name, int productivity) : Product(name, "Agricultural Machine"), productivity(productivity) {}
    void assemble() override {
        cout << "Assembling Agricultural Machine: " << name << " (Productivity: " << productivity << " units/hour)" << endl;
    }
};
class Workshop {
protected:
    string name;
    vector<Product*> products;
public:
    Workshop(const string& name) : name(name) {}

    void addProduct(Product* product) {
        products.push_back(product);
    }
    void assembleProducts() {
        cout << "Assembling products in " << name << ":" << endl;
        for (Product* product : products) {
            product->assemble();
        }
        cout << endl;
    }
};
int main() {
    Workshop workshop1("Workshop 1");
    Workshop workshop2("Workshop 2");
    Bus bus1("Bus 1", 50);
    Bus bus2("Bus 2", 30);
    AgriculturalMachine machine1("Machine 1", 100);
    AgriculturalMachine machine2("Machine 2", 80);
    workshop1.addProduct(&bus1);
    workshop1.addProduct(&machine1);
    workshop2.addProduct(&bus2);
    workshop2.addProduct(&machine2);
    workshop1.assembleProducts();
    workshop2.assembleProducts();
    return 0;
}
