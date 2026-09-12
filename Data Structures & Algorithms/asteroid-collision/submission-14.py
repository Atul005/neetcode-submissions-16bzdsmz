class Solution:
    def asteroidCollision(self, ast: List[int]) -> List[int]:
        stk = []
        n  = len(ast)

        for i in range(n):
            is_vanished = False
            if ast[i] > 0:
                stk.append(ast[i])
            else:
                if not stk or stk[-1] < 0:
                    stk.append(ast[i])

                else:
                    if stk[-1] > 0 and stk[-1] == abs(ast[i]):
                        stk.pop()
                        continue
                    elif stk[-1] > abs(ast[i]):
                        continue
                    else:
                        while stk and stk[-1] > 0:
                            if abs(stk[-1]) < abs(ast[i]):
                                stk.pop()
                                is_vanished = False
                            elif abs(stk[-1]) == abs(ast[i]):
                                stk.pop()
                                is_vanished = True
                                break
                            else:
                                is_vanished = True
                                break    

                        if not is_vanished:
                            stk.append(ast[i])  

        return stk                      



        