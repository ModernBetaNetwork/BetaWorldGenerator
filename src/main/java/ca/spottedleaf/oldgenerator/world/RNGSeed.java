package ca.spottedleaf.oldgenerator.world;

public class RNGSeed {

    private static long mix(long x) {
        x = (x ^ (x >>> 30)) * 0xbf58476d1ce4e5b9L;
        x = (x ^ (x >>> 27)) * 0x94d049bb133111ebL;
        x = x ^ (x >>> 31);
        return x;
    }

    public static long getRNGSeed(int chunkX, int chunkZ, long worldSeed, long oreSalt) {
        long h = 0x9e3779b97f4a7c15L;
        h ^= mix(chunkX);
        h ^= mix(chunkZ);
        h ^= mix(worldSeed);
        h ^= mix(oreSalt);

        return h;
    }
}