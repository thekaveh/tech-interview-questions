from algoexpert.easy.two_number_sum.solution_1 import two_number_sum


def test_basic_example():
    pair = two_number_sum([3, 5, -4, 8, 11, 1, -1, 6], 10)
    assert sorted(pair) == [-1, 11]


def test_no_pair():
    assert two_number_sum([1, 2, 3], 100) == []


def test_negative_target():
    pair = two_number_sum([1, -2, 3, -4], -6)
    assert sorted(pair) == [-4, -2]
