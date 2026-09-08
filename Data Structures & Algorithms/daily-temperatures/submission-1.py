class Solution:
    def dailyTemperatures(self, temp: List[int]) -> List[int]:
        
        n = len(temp)
        res = [0]*n
        stk = []

        for j in range(n-1, -1, -1):

            while len(stk) > 0 and temp[stk[-1]] <= temp[j]:
                stk.pop()
            
            if not stk:
                res[j] = 0
            else:
                res[j] = stk[-1] - j
            stk.append(j)   


        return res     




        