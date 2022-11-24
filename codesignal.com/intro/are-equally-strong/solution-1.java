boolean solution(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
    return ((yourLeft + yourRight) == (friendsLeft + friendsRight))
        && ((yourLeft == friendsLeft) || (yourLeft == friendsRight));
}