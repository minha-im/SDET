import pytest

# Data fixtures
@pytest.fixture
def user_data():
    return {
        'username': 'test_user',
        'email': 'test_user@example.com',
        'password': 'password123'
    }

@pytest.fixture
def product_data():
    return {
        'product_id': 12345,
        'name': 'Test Product',
        'price': 19.99
    }

# Test functions using fixtures
def test_user_creation(user_data):
    assert 'username' in user_data
    assert 'email' in user_data
    assert 'password' in user_data
    # Add test logic for user creation using user_data fixture

def test_product_creation(product_data):
    assert 'product_id' in product_data
    assert 'name' in product_data
    assert 'price' in product_data
    # Add test logic for product creation using product_data fixture
