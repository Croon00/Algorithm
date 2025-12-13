def solution(n, a, b):
    answer = 0

    # a와 b가 같은 번호가 될 때(= 같은 대진으로 만날 때)까지 라운드 진행
    while a != b:
        a = (a + 1) // 2
        b = (b + 1) // 2
        answer += 1

    return answer
