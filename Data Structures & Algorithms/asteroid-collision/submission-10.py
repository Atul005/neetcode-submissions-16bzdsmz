class Solution:
    def asteroidCollision(self, ast: List[int]) -> List[int]:
        stk = []
        n = len(ast)
        

        for i in range(n):
            is_vanished = False

            while stk and ast[i] < 0 and stk[-1] > 0:
                val = abs(ast[i])

                if stk[-1] < val:
                    stk.pop()

                elif stk[-1] == val:
                    stk.pop()
                    is_vanished = True
                    break
                
                else:
                    is_vanished = True
                    break
            if not is_vanished:
                stk.append(ast[i])
  
        return stk        