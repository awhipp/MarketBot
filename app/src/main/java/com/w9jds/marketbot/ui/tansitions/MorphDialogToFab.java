package com.w9jds.marketbot.ui.tansitions;

import android.transition.ChangeBounds;

/**
 * A transition that morphs a rectangle into a circle, changing it's background color.
 */
public class MorphDialogToFab extends ChangeBounds {
//
//    private static final String PROPERTY_COLOR = "io.plaidapp:rectMorph:color";
//    private static final String PROPERTY_CORNER_RADIUS = "plaid:rectMorph:cornerRadius";
//    private static final String[] TRANSITION_PROPERTIES = {
//            PROPERTY_COLOR,
//            PROPERTY_CORNER_RADIUS
//    };
//
//    private @ColorInt
//    int endColor = Color.TRANSPARENT;
//    private int endCornerRadius = -1;
//
//    public MorphDialogToFab(@ColorInt int endColor) {
//        super();
//        setEndColor(endColor);
//    }
//
//    public MorphDialogToFab(@ColorInt int endColor, int endCornerRadius) {
//        super();
//        setEndColor(endColor);
//        setEndCornerRadius(endCornerRadius);
//    }
//
//    public MorphDialogToFab(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public void setEndColor(@ColorInt int endColor) {
//        this.endColor = endColor;
//    }
//
//    public void setEndCornerRadius(int endCornerRadius) {
//        this.endCornerRadius = endCornerRadius;
//    }
//
//    @Override
//    public String[] getTransitionProperties() {
//        return TRANSITION_PROPERTIES;
//    }
//
//    @Override
//    public void captureStartValues(TransitionValues transitionValues) {
//        super.captureStartValues(transitionValues);
//        final View view = transitionValues.view;
//        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
//            return;
//        }
//        transitionValues.values.put(PROPERTY_COLOR,
//                ContextCompat.getColor(view.getContext(), R.color.background_light));
//        transitionValues.values.put(PROPERTY_CORNER_RADIUS, view.getResources()
//                .getDimensionPixelSize(R.dimen.dialog_corners));
//    }
//
//    @Override
//    public void captureEndValues(TransitionValues transitionValues) {
//        super.captureEndValues(transitionValues);
//        final View view = transitionValues.view;
//        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
//            return;
//        }
//        transitionValues.values.put(PROPERTY_COLOR, endColor);
//        transitionValues.values.put(PROPERTY_CORNER_RADIUS,
//                endCornerRadius >= 0 ? endCornerRadius : view.getHeight() / 2);
//    }
//
//    @Override
//    public Animator createAnimator(final ViewGroup sceneRoot,
//                                   TransitionValues startValues,
//                                   TransitionValues endValues) {
//        Animator changeBounds = super.createAnimator(sceneRoot, startValues, endValues);
//        if (startValues == null || endValues == null || changeBounds == null) {
//            return null;
//        }
//
//        Integer startColor = (Integer) startValues.values.get(PROPERTY_COLOR);
//        Integer startCornerRadius = (Integer) startValues.values.get(PROPERTY_CORNER_RADIUS);
//        Integer endColor = (Integer) endValues.values.get(PROPERTY_COLOR);
//        Integer endCornerRadius = (Integer) endValues.values.get(PROPERTY_CORNER_RADIUS);
//
//        if (startColor == null || startCornerRadius == null || endColor == null ||
//                endCornerRadius == null) {
//            return null;
//        }
//
//        MorphDrawable background = new MorphDrawable(startColor, startCornerRadius);
//        endValues.view.setBackground(background);
//
//        Animator color = ObjectAnimator.ofArgb(background, background.COLOR, endColor);
//        Animator corners = ObjectAnimator.ofFloat(background, background.CORNER_RADIUS,
//                endCornerRadius);
//
//        // hide child views (offset down & fade out)
//        if (endValues.view instanceof ViewGroup) {
//            ViewGroup vg = (ViewGroup) endValues.view;
//            for (int i = 0; i < vg.getChildCount(); i++) {
//                View v = vg.getChildAt(i);
//                v.animate()
//                        .alpha(0f)
//                        .translationY(v.getHeight() / 3)
//                        .setStartDelay(0L)
//                        .setDuration(50L)
//                        .setInterpolator(getFastOutLinearInInterpolator(vg.getContext()))
//                        .start();
//            }
//        }
//
//        AnimatorSet transition = new AnimatorSet();
//        transition.playTogether(changeBounds, corners, color);
//        transition.setDuration(300);
//        transition.setInterpolator(getFastOutSlowInInterpolator(sceneRoot.getContext()));
//        return transition;
//    }
}
