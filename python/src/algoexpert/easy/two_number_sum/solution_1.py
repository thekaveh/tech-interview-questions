# Approach: Hash set, single pass.

def two_number_sum(numbers: list[int], target: int) -> list[int]:
    seen: set[int] = set()
    for n in numbers:
        complement = target - n
        if complement in seen:
            return [complement, n]
        seen.add(n)
    return []
