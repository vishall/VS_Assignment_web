package utils.builders;

import utils.State;
import enums.Conditions;

public class WFBuilder
{
    public boolean scrollTo;
    public Conditions conditions;
    public long timeoutSeconds;
    public boolean failOnNotFound;
    public int scrollToOffset;

    private WFBuilder(Builder builder)
    {
        scrollTo = builder.scrollTo;
        conditions = builder.conditions;
        timeoutSeconds = builder.timeoutSeconds;
        failOnNotFound = builder.failOnNotFound;
        scrollToOffset = builder.scrollToOffset;
    }

    public static Builder options()
    {
        return new Builder();
    }

    public static final class Builder
    {
        private boolean scrollTo = false;
        private Conditions conditions = Conditions.CLICKABLE;
        private long timeoutSeconds = State.defaultTimeout;
        private boolean failOnNotFound = true;
        private int scrollToOffset = -200;

        private Builder()
        {
        }

        public Builder conditions(Conditions val)
        {
            conditions = val;
            return this;
        }

        public Builder timeoutSeconds(long val)
        {
            timeoutSeconds = val;
            return this;
        }

        public Builder failOnNotFound(boolean val)
        {
            failOnNotFound = val;
            return this;
        }

        public Builder scrollTo(boolean val)
        {
            scrollTo = val;
            return this;
        }

        public Builder scrollToOffset(int val)
        {
            scrollToOffset = val;
            scrollTo = true;
            return this;
        }

        public WFBuilder build()
        {
            return new WFBuilder(this);
        }

    }
}
