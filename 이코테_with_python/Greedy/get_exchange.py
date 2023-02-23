exchange = 1260
count = 0

monetary_unit = [500, 100, 50, 10]

for coin in monetary_unit :
    count += exchange // coin
    exchange %= coin

print(coin)
