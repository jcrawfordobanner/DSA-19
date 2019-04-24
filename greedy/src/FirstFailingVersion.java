public class FirstFailingVersion {

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
        // TODO
        while (isBadVersion.isFailingVersion(n)){
            if(isBadVersion.isFailingVersion(n/2)){
                n=n/2;
                continue;
            }
            n-=1;
        }
        n+=1;
        return n;
    }
}
