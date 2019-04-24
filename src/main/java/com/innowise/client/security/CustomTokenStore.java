package com.innowise.client.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

@Configuration
public class CustomTokenStore extends JdbcTokenStore {

    private static final Logger LOG = LoggerFactory.getLogger(CustomTokenStore.class);

    public CustomTokenStore(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        OAuth2AccessToken accessToken = null;

        try {
            accessToken = new DefaultOAuth2AccessToken(tokenValue);
        }
        catch (EmptyResultDataAccessException e) {
            if (LOG.isInfoEnabled()) {
                LOG.info("-Failed to find access token for token "+tokenValue);
            }
        }
        catch (IllegalArgumentException e) {
            LOG.warn("-Failed to deserialize access token for " +tokenValue,e);
            removeAccessToken(tokenValue);
        }

        return accessToken;
    }
    /*@Override
    protected OAuth2Authentication deserializeAuthentication(byte[] authentication) {
        return deserialize(authentication);
    }

    @Override
    protected OAuth2AccessToken deserializeAccessToken(byte[] token) {
        return deserialize(token);
    }

    @Override
    protected OAuth2RefreshToken deserializeRefreshToken(byte[] token) {
        return deserialize(token);
    }

    @SuppressWarnings("unchecked")
    private <T> T deserialize(byte[] authentication) {
        try {
            return (T) super.deserializeAuthentication(authentication);
        } catch (Exception e) {
            try (ObjectInputStream input = new FixSerialVersionUUID(authentication)) {
                return (T) input.readObject();
            } catch (IOException | ClassNotFoundException e1) {
                throw new IllegalArgumentException(e1);
            }
        }
    }


private class FixSerialVersionUUID extends ObjectInputStream {

    public FixSerialVersionUUID(byte[] bytes) throws IOException {
        super(new ByteArrayInputStream(bytes));
    }

    @Override
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();

        if (resultClassDescriptor.getName().equals(SimpleGrantedAuthority.class.getName())) {
            ObjectStreamClass mostRecentSerialVersionUUID = ObjectStreamClass.lookup(SimpleGrantedAuthority.class);
            return mostRecentSerialVersionUUID;
        }

        return resultClassDescriptor;
    }


}*/
}

