def solution(schedules, timelogs, startday):
    answer = 0
    for sched, logs in zip(schedules, timelogs):
        day = startday
        success = True

        for time in logs:
            if day in (6, 7):  # 토, 일은 건너뛰기
                day = 1 if day == 7 else day + 1
                continue
            
            limit = sched + 10
            if limit % 100 >= 60:
                limit += 40  # 60분 이상이면 시간+1, 분-60 → 결국 +40
            
            if time > limit:
                success = False
                break
            
            day = 1 if day == 7 else day + 1

        if success:
            answer += 1

    return answer