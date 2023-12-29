#include <iostream>
#include <vector>
#include <memory>
template <typename T>
void printContainer(const T& container) {
    for (const auto& element : container) {
        std::cout << element << " ";
    }
    std::cout << std::endl;
}
template <typename T>
class Product {
public:
    Product(const T& attribute) : attribute_(attribute) {}
    void setAttribute(const T& attribute) {
        attribute_ = attribute;
    }
    T getAttribute() const {
        return attribute_;
    }
private:
    T attribute_;
};
int main() {
    std::vector<int> numbers = {1, 2, 3, 4, 5};
    printContainer(numbers);
int
    Product<int> intProduct(10);
    std::cout << intProduct.getAttribute() << std::endl;
типу double
    std::shared_ptr<Product<double>> doubleProduct = std::make_shared<Product<double>>(5.5);
    std::cout << doubleProduct->getAttribute() << std::endl;
    return 0;
}
