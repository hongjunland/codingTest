from collections import deque

dr = [0, 1, -1, 0]
dc = [1, 0, 0, -1]


def solution(game_board, table):
    ROW_SIZE = len(table)
    COL_SIZE = len(table[0])
    answer = 0
    visited = [[False for _ in range(ROW_SIZE)] for _ in range(COL_SIZE)]
    puzzles = []

    def get_puzzle(start_row, start_col, value):
        result = [[0, 0]]
        queue = deque([[start_row, start_col]])
        visited[start_row][start_col] = True
        while queue:
            r, c = queue.popleft()
            for i in range(4):
                nr = r + dr[i]
                nc = c + dc[i]
                if 0 <= nr < ROW_SIZE and 0 <= nc < COL_SIZE and not visited[nr][nc] and table[nr][nc] == value:
                    visited[nr][nc] = True
                    queue.append([nr, nc])
                    result.append([nr - start_row, nc - start_col])
        result.sort()
        return result

    for i in range(ROW_SIZE):
        for j in range(COL_SIZE):
            if not visited[i][j] and table[i][j] == 1:
                puzzles.append(get_puzzle(i, j))

    for i in range(ROW_SIZE):
        for j in range(COL_SIZE):
            if game_board[i][j] == 0:
                space = get_space(i, j)
                for puzzle in puzzles:
                    if space == puzzle:
                        answer += len(space)

    # for puzzle in puzzles:
    #     print(puzzle)
    return answer


if __name__ == '__main__':
    print(solution([[1, 1, 0, 0, 1, 0], [0, 0, 1, 0, 1, 0], [0, 1, 1, 0, 0, 1], [1, 1, 0, 1, 1, 1], [1, 0, 0, 0, 1, 0],
                    [0, 1, 1, 1, 0, 0]],
                   [[1, 0, 0, 1, 1, 0], [1, 0, 1, 0, 1, 0], [0, 1, 1, 0, 1, 1], [0, 0, 1, 0, 0, 0], [1, 1, 0, 1, 1, 0],
                    [0, 1, 0, 0, 0, 0]]))
    # print(solution([[0, 0, 0], [1, 1, 0], [1, 1, 1]], [[1, 1, 1], [1, 0, 0], [0, 0, 0]]))


