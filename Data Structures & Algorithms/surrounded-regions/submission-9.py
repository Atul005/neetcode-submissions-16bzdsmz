class Solution:

    def on_boundry(self, x, y, m, n):
        return x == 0 or x == m-1 or y == 0 or y == n-1

    def dfs(self, board, i, j, dirs, m, n, new_char):
        board[i][j] = new_char

        for dir in dirs:
            x = i + dir[0]
            y = j + dir[1]

            if x < m and x >= 0 and y >= 0 and y < n and board[x][y] == 'O':
                    self.dfs(board, x, y, dirs, m, n, new_char) 



    def solve(self, board: List[List[str]]) -> None:
        
        m = len(board)
        n = len(board[0])

        dirs = [[-1, 0],[1, 0],[0, 1],[0, -1]]
        boundry_o = []

        for i in range(m):
            for j in range(n):
                if i == 0 and board[i][j] == 'O':
                    self.dfs(board, i, j, dirs, m, n, 'A')
                    

                elif i == m-1 and board[i][j] == 'O':
                    self.dfs(board, i, j, dirs, m, n, 'A')
                    

                elif j == 0 and board[i][j] == 'O':
                    self.dfs(board, i, j, dirs, m, n, 'A')

                elif j == n-1 and board[i][j] == 'O':
                    self.dfs(board, i, j, dirs, m, n, 'A')  


        # for i in range(m):
        #     for j in range(n):
        #         if board[i][j] == 'O' and not self.on_boundry(i, j, m, n):
        #             self.dfs(board, i, j, dirs, m, n, 'X')

        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    board[i][j] = 'X'

        for i in range(m):
            for j in range(n):
                if board[i][j] == 'A':
                    board[i][j] = 'O'
                                

        