#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Product {
protected:
    string name;
public:
    Product(const string& name) : name(name) {}
    virtual void assemble() = 0; 
    virtual string getCategory() = 0;
};
class Car : public Product {
private:
    int capacity; 
public:
    Car(const string& name, int capacity) : Product(name), capacity(capacity) {}

    void assemble() override {
        cout << "Збирання легкового автомобіля " << name << endl;
    }
    string getCategory() override {
        return "Легковий автомобіль";
    }
};
class Bus : public Product {
private:
    int capacity;
public:
    Bus(const string& name, int capacity) : Product(name), capacity(capacity) {}

    void assemble() override {
        cout << "Збирання автобуса " << name << endl;
    }

    string getCategory() override {
        return "Автобус";
    }
};
class Workshop {
private:
    string name;
    vector<Product*> products;
public:
    Workshop(const string& name) : name(name) {}

    void addProduct(Product* product) {
        products.push_back(product);
    }

    void assembleAllProducts() {
       cout << "Збирання виробів у цеху " << name << endl;
        for (Product* product : products) {
            product->assemble();
        }
    }
};
int main() {
    Workshop workshop("Цех №1");
    Car car1("Легковий автомобіль 1", 4);
    Car car2("Легковий автомобіль 2", 5);
    Bus bus1("Автобус 1", 50);
    workshop.addProduct(&car1);
    workshop.addProduct(&car2);
    workshop.addProduct(&bus1);
    workshop.assembleAllProducts();
    return 0;
}
