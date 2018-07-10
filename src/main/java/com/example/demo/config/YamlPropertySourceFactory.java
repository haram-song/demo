/**
 *  SMCP version 1.0
 *
 *  Copyright ⓒ 2018 kt corp. All rights reserved.
 *
 *  This is a proprietary software of kt corp, and you may not use this file except in
 *  compliance with license agreement with kt corp. Any redistribution or use of this
 *  software, with or without modification shall be strictly prohibited without prior written
 *  approval of kt corp, and the copyright notice above does not evidence any actual or
 *  intended publication of such software.
 *
 * @author kt
 * @since 2015.07.15
 * @version 1.0
 * @see 
 * @Copyright © 2015 By KT corp. All rights reserved.
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *  수정일               수정자                수정내용
 *  -------------        ----------       -------------------------
 *  2015.07.15           [성명]               최초생성            
 *
 *
 * </pre>
 */

package com.example.demo.config;

import java.io.IOException;

import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.util.StringUtils;


/**
 *
 */
public class YamlPropertySourceFactory implements PropertySourceFactory { 
    private static final String YML_FILE_EXTENSION = ".yml"; 
    @Override 
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException { 
        String filename = resource.getResource().getFilename(); 
        if (filename != null && filename.endsWith(YML_FILE_EXTENSION)) { 
            return name != null ? new YamlResourcePropertySource(name, resource) : new YamlResourcePropertySource(getNameForResource(resource.getResource()), resource); 
        } 
        
        return (name != null ? new ResourcePropertySource(name, resource) : new ResourcePropertySource(resource)); 
    } 
    
    private String getNameForResource(Resource resource) { 
        String name = resource.getDescription(); 
        
        if (!StringUtils.hasText(name)) { 
            name = resource.getClass().getSimpleName() + "@" + System.identityHashCode(resource); 
        } 
        
        return name; 
    } 
} 