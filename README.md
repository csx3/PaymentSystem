
## Uygulanan Yapi

- `PaymentMethod` arayuzu tum odeme yontemleri icin ortak kontrati tanimlar.
- `CreditCardPayment` mevcut odeme yontemini temsil eder.
- `PayPalPayment` sisteme yeni eklenen odeme yontemidir.
- `PaymentService`, odeme akisini yonetir.

## SOLID Yaklasimi

### Open/Closed Principle

Yeni bir odeme yontemi eklemek icin mevcut akisi degistirmeden `PaymentMethod` arayuzunu implemente eden yeni bir sinif yazmak yeterlidir.

### Single Responsibility Principle

- `PaymentService` sadece odeme akisini yonetir.
- Her odeme sinifi sadece kendi odeme davranisindan sorumludur.



