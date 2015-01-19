package Java.com.dethsanius.Game.WIR.lib;

import java.awt.*;

/**
 * Created by Dethsanius on 17.07.2014, project is Games 2D package are Java.com.dethsanius.Game.WIR.lib.
 */
public class refferences {
    public static boolean breaking = false, rightBoolRalph = true, rightBoolFelix = true, hammerTime = false, ralphRight = false, ralphUp = true, felixRight = false, felixUp = true, pause = true;
    public static boolean ralphComp = false, felixComp = false, coop = false;
    public static int winSice = 0, possRalph = 56, possFelix = 59, vertRalph = 0, horiRalph = 0, vertFelix, horiFelix, fullWindows = 0, halfWindows = 0, brokenWindows = 0, milli = 0, sec = 0, min = 0,
            winState[] = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
    public static Rectangle[][] Window = {
            {new Rectangle(300, 154, 15, 13), new Rectangle(337, 154, 15, 13), new Rectangle(379, 155, 15, 13), new Rectangle(422, 154, 15, 13), new Rectangle(459, 154, 15, 13),
                    new Rectangle(300, 167, 15, 13), new Rectangle(337, 167, 15, 13), new Rectangle(379, 168, 15, 13), new Rectangle(422, 167, 15, 13), new Rectangle(459, 167, 15, 13),
                    new Rectangle(300, 184, 15, 13), new Rectangle(337, 184, 15, 13), new Rectangle(422, 184, 15, 13), new Rectangle(459, 184, 15, 13),
                    new Rectangle(300, 240, 15, 13), new Rectangle(337, 240, 15, 13), new Rectangle(379, 240, 15, 13), new Rectangle(422, 240, 15, 13), new Rectangle(459, 240, 15, 13),
                    new Rectangle(300, 257, 15, 13), new Rectangle(337, 257, 15, 13), new Rectangle(379, 257, 15, 13), new Rectangle(422, 257, 15, 13), new Rectangle(459, 257, 15, 13),
                    new Rectangle(300, 313, 15, 13), new Rectangle(337, 313, 15, 13), new Rectangle(379, 313, 15, 13), new Rectangle(422, 313, 15, 13), new Rectangle(459, 313, 15, 13),
                    new Rectangle(300, 330, 15, 13), new Rectangle(337, 330, 15, 13), new Rectangle(379, 330, 15, 13), new Rectangle(422, 330, 15, 13), new Rectangle(459, 330, 15, 13),
                    new Rectangle(300, 372, 15, 13), new Rectangle(337, 372, 15, 13), new Rectangle(379, 372, 15, 13), new Rectangle(422, 372, 15, 13), new Rectangle(459, 372, 15, 13),
                    new Rectangle(300, 388, 15, 13), new Rectangle(337, 388, 15, 13), new Rectangle(379, 388, 15, 13), new Rectangle(422, 388, 15, 13), new Rectangle(459, 388, 15, 13),
                    new Rectangle(300, 442, 15, 13), new Rectangle(337, 442, 15, 13), new Rectangle(422, 442, 15, 13), new Rectangle(459, 442, 15, 13),
                    new Rectangle(300, 459, 15, 13), new Rectangle(337, 459, 15, 13), new Rectangle(422, 459, 15, 13), new Rectangle(459, 459, 15, 13),
                    new Rectangle(300, 501, 15, 13), new Rectangle(337, 501, 15, 13), new Rectangle(422, 501, 15, 13), new Rectangle(459, 501, 15, 13),
                    new Rectangle(300, 518, 15, 13), new Rectangle(337, 518, 15, 13), new Rectangle(422, 518, 15, 13), new Rectangle(459, 518, 15, 13)},
            {new Rectangle(449, 161, 19, 14), new Rectangle(495, 161, 19, 14), new Rectangle(548, 161, 19, 14), new Rectangle(601, 161, 19, 14), new Rectangle(647, 161, 19, 14),
                    new Rectangle(449, 176, 19, 14), new Rectangle(495, 176, 19, 14), new Rectangle(548, 176, 19, 14), new Rectangle(601, 176, 19, 14), new Rectangle(647, 176, 19, 14),
                    new Rectangle(449, 193, 19, 14), new Rectangle(495, 193, 19, 14), new Rectangle(601, 193, 19, 14), new Rectangle(647, 193, 19, 14),
                    new Rectangle(449, 254, 19, 14), new Rectangle(495, 254, 19, 14), new Rectangle(548, 254, 19, 14), new Rectangle(601, 254, 19, 14), new Rectangle(647, 254, 19, 14),
                    new Rectangle(449, 273, 19, 14), new Rectangle(495, 273, 19, 14), new Rectangle(548, 273, 19, 14), new Rectangle(601, 273, 19, 14), new Rectangle(647, 273, 19, 14),
                    new Rectangle(449, 333, 19, 14), new Rectangle(495, 333, 19, 14), new Rectangle(548, 333, 19, 14), new Rectangle(601, 333, 19, 14), new Rectangle(647, 333, 19, 14),
                    new Rectangle(449, 352, 19, 14), new Rectangle(495, 352, 19, 14), new Rectangle(548, 352, 19, 14), new Rectangle(601, 352, 19, 14), new Rectangle(647, 352, 19, 14),
                    new Rectangle(449, 397, 19, 14), new Rectangle(495, 397, 19, 14), new Rectangle(548, 397, 19, 14), new Rectangle(601, 397, 19, 14), new Rectangle(647, 397, 19, 14),
                    new Rectangle(449, 415, 19, 14), new Rectangle(495, 415, 19, 14), new Rectangle(548, 415, 19, 14), new Rectangle(601, 415, 19, 14), new Rectangle(647, 415, 19, 14),
                    new Rectangle(449, 475, 19, 14), new Rectangle(495, 475, 19, 14), new Rectangle(601, 475, 19, 14), new Rectangle(647, 475, 19, 14),
                    new Rectangle(449, 491, 19, 14), new Rectangle(495, 491, 19, 14), new Rectangle(601, 491, 19, 14), new Rectangle(647, 491, 19, 14),
                    new Rectangle(449, 536, 19, 14), new Rectangle(495, 536, 19, 14), new Rectangle(601, 536, 19, 14), new Rectangle(647, 536, 19, 14),
                    new Rectangle(449, 554, 19, 14), new Rectangle(495, 554, 19, 14), new Rectangle(601, 554, 19, 14), new Rectangle(647, 554, 19, 14)},
            {new Rectangle(504, 173, 21, 16), new Rectangle(553, 173, 21, 16), new Rectangle(609, 173, 21, 16), new Rectangle(666, 173, 21, 16), new Rectangle(715, 173, 21, 16),
                    new Rectangle(504, 189, 21, 16), new Rectangle(553, 189, 21, 16), new Rectangle(609, 189, 21, 16), new Rectangle(666, 189, 21, 16), new Rectangle(715, 189, 21, 16),
                    new Rectangle(504, 208, 21, 16), new Rectangle(553, 208, 21, 16), new Rectangle(666, 208, 21, 16), new Rectangle(715, 208, 21, 16),
                    new Rectangle(504, 275, 21, 16), new Rectangle(553, 275, 21, 16), new Rectangle(609, 275, 21, 16), new Rectangle(666, 275, 21, 16), new Rectangle(715, 275, 21, 16),
                    new Rectangle(504, 295, 21, 16), new Rectangle(553, 295, 21, 16), new Rectangle(609, 295, 21, 16), new Rectangle(666, 295, 21, 16), new Rectangle(715, 295, 21, 16),
                    new Rectangle(504, 361, 21, 16), new Rectangle(553, 361, 21, 16), new Rectangle(609, 361, 21, 16), new Rectangle(666, 361, 21, 16), new Rectangle(715, 361, 21, 16),
                    new Rectangle(504, 381, 21, 16), new Rectangle(553, 381, 21, 16), new Rectangle(609, 381, 21, 16), new Rectangle(666, 381, 21, 16), new Rectangle(715, 381, 21, 16),
                    new Rectangle(504, 431, 21, 16), new Rectangle(553, 431, 21, 16), new Rectangle(609, 431, 21, 16), new Rectangle(666, 431, 21, 16), new Rectangle(715, 431, 21, 16),
                    new Rectangle(504, 450, 21, 16), new Rectangle(553, 450, 21, 16), new Rectangle(609, 450, 21, 16), new Rectangle(666, 450, 21, 16), new Rectangle(715, 450, 21, 16),
                    new Rectangle(504, 514, 21, 16), new Rectangle(553, 514, 21, 16), new Rectangle(666, 514, 21, 16), new Rectangle(715, 514, 21, 16),
                    new Rectangle(504, 534, 21, 16), new Rectangle(553, 534, 21, 16), new Rectangle(666, 534, 21, 16), new Rectangle(715, 534, 21, 16),
                    new Rectangle(504, 583, 21, 16), new Rectangle(553, 583, 21, 16), new Rectangle(666, 583, 21, 16), new Rectangle(715, 583, 21, 16),
                    new Rectangle(504, 603, 21, 16), new Rectangle(553, 603, 21, 16), new Rectangle(666, 603, 21, 16), new Rectangle(715, 603, 21, 16)},
            {new Rectangle(663, 248, 24, 19), new Rectangle(718, 248, 24, 19), new Rectangle(781, 248, 24, 19), new Rectangle(844, 248, 24, 19), new Rectangle(899, 248, 24, 19),
                    new Rectangle(663, 266, 24, 19), new Rectangle(718, 266, 24, 19), new Rectangle(781, 266, 24, 19), new Rectangle(844, 266, 24, 19), new Rectangle(899, 266, 24, 19),
                    new Rectangle(663, 289, 24, 19), new Rectangle(718, 289, 24, 19), new Rectangle(844, 289, 24, 19), new Rectangle(899, 289, 24, 19),
                    new Rectangle(663, 371, 24, 19), new Rectangle(718, 371, 24, 19), new Rectangle(781, 371, 24, 19), new Rectangle(844, 371, 24, 19), new Rectangle(899, 371, 24, 19),
                    new Rectangle(663, 395, 24, 19), new Rectangle(718, 395, 24, 19), new Rectangle(781, 395, 24, 19), new Rectangle(844, 395, 24, 19), new Rectangle(899, 395, 24, 19),
                    new Rectangle(663, 475, 24, 19), new Rectangle(718, 475, 24, 19), new Rectangle(781, 475, 24, 19), new Rectangle(844, 475, 24, 19), new Rectangle(899, 475, 24, 19),
                    new Rectangle(663, 499, 24, 19), new Rectangle(718, 499, 24, 19), new Rectangle(781, 499, 24, 19), new Rectangle(844, 499, 24, 19), new Rectangle(899, 499, 24, 19),
                    new Rectangle(663, 558, 24, 19), new Rectangle(718, 558, 24, 19), new Rectangle(781, 558, 24, 19), new Rectangle(844, 558, 24, 19), new Rectangle(899, 558, 24, 19),
                    new Rectangle(663, 581, 24, 19), new Rectangle(718, 581, 24, 19), new Rectangle(781, 581, 24, 19), new Rectangle(844, 581, 24, 19), new Rectangle(899, 581, 24, 19),
                    new Rectangle(663, 658, 24, 19), new Rectangle(718, 658, 24, 19), new Rectangle(844, 658, 24, 19), new Rectangle(899, 658, 24, 19),
                    new Rectangle(663, 682, 24, 19), new Rectangle(718, 682, 24, 19), new Rectangle(844, 682, 24, 19), new Rectangle(899, 682, 24, 19),
                    new Rectangle(663, 742, 24, 19), new Rectangle(718, 742, 24, 19), new Rectangle(844, 742, 24, 19), new Rectangle(899, 742, 24, 19),
                    new Rectangle(663, 765, 24, 19), new Rectangle(718, 765, 24, 19), new Rectangle(844, 765, 24, 19), new Rectangle(899, 765, 24, 19)},
            {new Rectangle(794, 254, 29, 24), new Rectangle(864, 254, 29, 24), new Rectangle(944, 254, 29, 24), new Rectangle(1025, 254, 29, 24), new Rectangle(1095, 254, 29, 24),
                    new Rectangle(794, 277, 29, 24), new Rectangle(864, 277, 29, 24), new Rectangle(944, 277, 29, 24), new Rectangle(1025, 277, 29, 24), new Rectangle(1095, 277, 29, 24),
                    new Rectangle(794, 307, 29, 24), new Rectangle(864, 307, 29, 24), new Rectangle(1025, 307, 29, 24), new Rectangle(1095, 307, 29, 24),
                    new Rectangle(794, 409, 29, 24), new Rectangle(864, 409, 29, 24), new Rectangle(944, 409, 29, 24), new Rectangle(1025, 409, 29, 24), new Rectangle(1095, 409, 29, 24),
                    new Rectangle(794, 439, 29, 24), new Rectangle(864, 439, 29, 24), new Rectangle(944, 439, 29, 24), new Rectangle(1025, 439, 29, 24), new Rectangle(1095, 439, 29, 24),
                    new Rectangle(794, 539, 29, 24), new Rectangle(864, 539, 29, 24), new Rectangle(944, 539, 29, 24), new Rectangle(1025, 539, 29, 24), new Rectangle(1095, 539, 29, 24),
                    new Rectangle(794, 569, 29, 24), new Rectangle(864, 569, 29, 24), new Rectangle(944, 569, 29, 24), new Rectangle(1025, 569, 29, 24), new Rectangle(1095, 569, 29, 24),
                    new Rectangle(794, 644, 29, 24), new Rectangle(864, 644, 29, 24), new Rectangle(944, 644, 29, 24), new Rectangle(1025, 644, 29, 24), new Rectangle(1095, 644, 29, 24),
                    new Rectangle(794, 673, 29, 24), new Rectangle(864, 673, 29, 24), new Rectangle(944, 673, 29, 24), new Rectangle(1025, 673, 29, 24), new Rectangle(1095, 673, 29, 24),
                    new Rectangle(794, 769, 29, 24), new Rectangle(864, 769, 29, 24), new Rectangle(1025, 769, 29, 24), new Rectangle(1095, 769, 29, 24),
                    new Rectangle(794, 798, 29, 24), new Rectangle(864, 798, 29, 24), new Rectangle(1025, 798, 29, 24), new Rectangle(1095, 798, 29, 24),
                    new Rectangle(794, 874, 29, 24), new Rectangle(864, 874, 29, 24), new Rectangle(1025, 874, 29, 24), new Rectangle(1095, 874, 29, 24),
                    new Rectangle(794, 914, 29, 24), new Rectangle(864, 518, 29, 24), new Rectangle(1025, 518, 29, 24), new Rectangle(1095, 518, 29, 24)}};

    public static void setPause(boolean pause)
    {
        refferences.pause = pause;
    }
}
