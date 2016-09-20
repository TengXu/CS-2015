#
# ps10pr4.py (Problem Set 10, Problem 4)
#
# An AI Player for Connect Four
#
# name:  Teng Tu
# email: xt@bu.edu
#
# If you worked with a partner, put his or her contact info below:
# partner's name:
# partner's email:
#

from ps10pr3 import *
import random

class AIPlayer(Player):
    """ takes the approach outlined above (and in more detail below)
        to choose its next move
    """
    def __init__(self, checker, tiebreak, lookahead):
        """ constructs a new AIPlayer object
        """
        assert(checker == 'X' or checker == 'O')
        assert(tiebreak == 'LEFT' or tiebreak == 'RIGHT' or tiebreak == 'RANDOM')
        assert(lookahead >= 0)
        Player.__init__(self, checker)
        self.tiebreak = tiebreak
        self.lookahead = lookahead

    def __repr__(self):
        """ returns a string representing an AIPlayer object """
        return 'Player '+ self.checker + ' (' + self.tiebreak + ',' + str(self.lookahead)+ ')'
        

    def max_score_column(self, scores):
        """ takes a list scores containing a score for each column of the board, and
            that returns the index of the column with the maximum score. If one or
            more columns are tied for the maximum score, the method should apply the
            called AIPlayer‘s tiebreaking strategy to break the tie
        """
        m = max(scores)
        lst = []
        for x in range(len(scores)):
            if scores[x] == m:
                lst += [x]
        if self.tiebreak == 'LEFT':
            return lst[0]
        elif self.tiebreak == 'RIGHT':
            return lst[-1]
        else:
            return random.choice(lst)

    def scores_for(self, board):
        """ takes a Board object board and determines the called AIPlayer‘s scores for
            the columns in board
        """
        scores = [50] * board.width
        for col in range(board.width):
            if board.can_add_to(col) == False:
                scores[col] = -1
            elif board.is_win_for(self.checker):
                scores[col] = 100
            elif board.is_win_for(self.opponent_checker()):
                scores[col] = 0
            elif self.lookahead == 0:
                scores[col] = 50
            else:
                board.add_checker(self.checker, col)
                opponent = AIPlayer(self.opponent_checker(), self.tiebreak, (self.lookahead -1))
                opp_scores = opponent.scores_for(board)
                if max(opp_scores) == 100:
                    scores[col] = 0
                elif max(opp_scores) == 0:
                    scores[col] = 100
                elif max(opp_scores) == -1:
                    scores[col] = -1
                else:
                    scores[col] = 50
                board.remove_checker(col)
        return scores

    def next_move(self, board):
        """ overrides (i.e., replaces) the next_move method that is inherited from Player.
            Rather than asking the user for the next move, this version of next_move should
            return the called AIPlayer‘s judgment of its best possible move
        """
        self.num_moves += 1
        return self.max_score_column(self.scores_for(board))
