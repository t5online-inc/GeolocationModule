Pod::Spec.new do |spec|
  spec.name         = 'GeolocationModule'
  spec.version      = '1.0.0'
  spec.license      = { :type => 't5online' }
  spec.homepage     = 'https://github.com/t5online-inc/GeolocationModule'
  spec.authors      = { 't5online' => 'yslee@t5online.com' }
  spec.summary      = 'GeolocationModule(Nebula)'
  spec.source       = { :git => 'https://github.com/t5online-inc/GeolocationModule.git' }
  spec.source_files = 'ios/GeolocationModule/Shared/**/*.{h,m}'
  spec.framework    = 'Foundation', 'UIKit'
end
