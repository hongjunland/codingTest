"""
input : 216
output: 196
"""

number_input = int(input())
result = 0
for candidate_number in range(number_input):
    current_number = candidate_number
    digit_sum = 0
    while current_number > 0:
        digit_sum += current_number % 10
        current_number //= 10
    if digit_sum + candidate_number == number_input:
        result = candidate_number
        break
print(result)
